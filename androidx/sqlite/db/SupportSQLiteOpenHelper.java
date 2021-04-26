package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.IOException;
import java.util.List;
/* loaded from: classes.dex */
public interface SupportSQLiteOpenHelper {

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public static final String TAG = "SupportSQLite";
        public final int version;

        public Callback(int i2) {
            this.version = i2;
        }

        private void deleteDatabaseFile(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w(TAG, "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    try {
                        if (!new File(str).delete()) {
                            Log.e(TAG, "Could not delete the database file " + str);
                        }
                    } catch (Exception e2) {
                        Log.e(TAG, "error while deleting corrupted database file", e2);
                    }
                }
            } catch (Exception e3) {
                Log.w(TAG, "delete failed: ", e3);
            }
        }

        public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onCorruption(SupportSQLiteDatabase supportSQLiteDatabase) {
            Log.e(TAG, "Corruption reported by sqlite on database: " + supportSQLiteDatabase.getPath());
            if (!supportSQLiteDatabase.isOpen()) {
                deleteDatabaseFile(supportSQLiteDatabase.getPath());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = supportSQLiteDatabase.getAttachedDbs();
                } catch (SQLiteException unused) {
                }
                try {
                    supportSQLiteDatabase.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (list != null) {
                    for (Pair<String, String> next : list) {
                        deleteDatabaseFile((String) next.second);
                    }
                } else {
                    deleteDatabaseFile(supportSQLiteDatabase.getPath());
                }
            }
        }

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
            throw new SQLiteException("Can't downgrade database from version " + i2 + " to " + i3);
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public static class Configuration {
        @NonNull
        public final Callback callback;
        @NonNull
        public final Context context;
        @Nullable
        public final String name;

        /* loaded from: classes.dex */
        public static class Builder {
            public Callback mCallback;
            public Context mContext;
            public String mName;

            public Builder(@NonNull Context context) {
                this.mContext = context;
            }

            public Configuration build() {
                Callback callback = this.mCallback;
                if (callback != null) {
                    Context context = this.mContext;
                    if (context != null) {
                        return new Configuration(context, this.mName, callback);
                    }
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            public Builder callback(@NonNull Callback callback) {
                this.mCallback = callback;
                return this;
            }

            public Builder name(@Nullable String str) {
                this.mName = str;
                return this;
            }
        }

        public Configuration(@NonNull Context context, @Nullable String str, @NonNull Callback callback) {
            this.context = context;
            this.name = str;
            this.callback = callback;
        }

        public static Builder builder(Context context) {
            return new Builder(context);
        }
    }

    /* loaded from: classes.dex */
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z);
}
