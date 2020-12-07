package com.android.support.appcompat.storage.permission;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.android.support.appcompat.a;
import com.android.support.appcompat.storage.b;
import java.io.FileNotFoundException;
import java.io.OutputStream;
/* loaded from: classes10.dex */
public class GrantPermissionActivity extends Activity {
    private b Iy;
    private int mRequestCode = -1;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.C0013a.activity_grant_permission);
        Intent intent = getIntent();
        this.mRequestCode = intent.getIntExtra("request_code", -1);
        this.Iy = a.lf().bs(intent.getStringExtra("request_time_stamp"));
        le();
    }

    private void le() {
        try {
            startIntentSenderForResult((IntentSender) getIntent().getParcelableExtra("requestAccessIntentSender"), this.mRequestCode, null, 0, 0, 0, null);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            try {
                Z(i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (i2 == 0 && this.Iy.Ix != null) {
            this.Iy.Ix.ld();
        }
        a.lf().br(String.valueOf(this.Iy.timeStamp));
        finish();
    }

    private void Z(int i) throws FileNotFoundException {
        if (i == 1) {
            int delete = getContentResolver().delete(this.Iy.uri, this.Iy.Iv, this.Iy.selectionArgs);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(Integer.valueOf(delete));
            }
        } else if (i == 2) {
            int update = getContentResolver().update(this.Iy.uri, this.Iy.values, this.Iy.Iv, this.Iy.selectionArgs);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(Integer.valueOf(update));
            }
        } else if (i == 3) {
            ParcelFileDescriptor openFileDescriptor = getContentResolver().openFileDescriptor(this.Iy.uri, this.Iy.It);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(openFileDescriptor);
            }
        } else if (i == 4) {
            ParcelFileDescriptor openFileDescriptor2 = getContentResolver().openFileDescriptor(this.Iy.uri, this.Iy.It, this.Iy.Iw);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(openFileDescriptor2);
            }
        } else if (i == 5) {
            AssetFileDescriptor openAssetFile = getContentResolver().openAssetFile(this.Iy.uri, this.Iy.It, this.Iy.Iw);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(openAssetFile);
            }
        } else if (i == 6) {
            AssetFileDescriptor openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(this.Iy.uri, this.Iy.It);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(openAssetFileDescriptor);
            }
        } else if (i == 7) {
            AssetFileDescriptor openAssetFileDescriptor2 = getContentResolver().openAssetFileDescriptor(this.Iy.uri, this.Iy.It, this.Iy.Iw);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(openAssetFileDescriptor2);
            }
        } else if (i == 8) {
            ParcelFileDescriptor openFile = getContentResolver().openFile(this.Iy.uri, this.Iy.It, this.Iy.Iw);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(openFile);
            }
        } else if (i == 9) {
            OutputStream openOutputStream = getContentResolver().openOutputStream(this.Iy.uri);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(openOutputStream);
            }
        } else if (i == 10) {
            OutputStream openOutputStream2 = getContentResolver().openOutputStream(this.Iy.uri, this.Iy.It);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(openOutputStream2);
            }
        } else if (i == 11) {
            AssetFileDescriptor openTypedAssetFile = getContentResolver().openTypedAssetFile(this.Iy.uri, this.Iy.mimeType, this.Iy.Iu, this.Iy.Iw);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(openTypedAssetFile);
            }
        } else if (i == 12) {
            AssetFileDescriptor openTypedAssetFileDescriptor = getContentResolver().openTypedAssetFileDescriptor(this.Iy.uri, this.Iy.mimeType, this.Iy.Iu);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(openTypedAssetFileDescriptor);
            }
        } else if (i == 13) {
            AssetFileDescriptor openTypedAssetFileDescriptor2 = getContentResolver().openTypedAssetFileDescriptor(this.Iy.uri, this.Iy.mimeType, this.Iy.Iu, this.Iy.Iw);
            if (this.Iy.Ix != null) {
                this.Iy.Ix.p(openTypedAssetFileDescriptor2);
            }
        }
    }
}
