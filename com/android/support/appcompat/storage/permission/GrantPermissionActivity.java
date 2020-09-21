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
/* loaded from: classes8.dex */
public class GrantPermissionActivity extends Activity {
    private b Ho;
    private int mRequestCode = -1;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.C0012a.activity_grant_permission);
        Intent intent = getIntent();
        this.mRequestCode = intent.getIntExtra("request_code", -1);
        this.Ho = a.le().bp(intent.getStringExtra("request_time_stamp"));
        ld();
    }

    private void ld() {
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
                W(i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (i2 == 0 && this.Ho.Hn != null) {
            this.Ho.Hn.lc();
        }
        a.le().bo(String.valueOf(this.Ho.timeStamp));
        finish();
    }

    private void W(int i) throws FileNotFoundException {
        if (i == 1) {
            int delete = getContentResolver().delete(this.Ho.uri, this.Ho.Hl, this.Ho.selectionArgs);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(Integer.valueOf(delete));
            }
        } else if (i == 2) {
            int update = getContentResolver().update(this.Ho.uri, this.Ho.values, this.Ho.Hl, this.Ho.selectionArgs);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(Integer.valueOf(update));
            }
        } else if (i == 3) {
            ParcelFileDescriptor openFileDescriptor = getContentResolver().openFileDescriptor(this.Ho.uri, this.Ho.Hj);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(openFileDescriptor);
            }
        } else if (i == 4) {
            ParcelFileDescriptor openFileDescriptor2 = getContentResolver().openFileDescriptor(this.Ho.uri, this.Ho.Hj, this.Ho.Hm);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(openFileDescriptor2);
            }
        } else if (i == 5) {
            AssetFileDescriptor openAssetFile = getContentResolver().openAssetFile(this.Ho.uri, this.Ho.Hj, this.Ho.Hm);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(openAssetFile);
            }
        } else if (i == 6) {
            AssetFileDescriptor openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(this.Ho.uri, this.Ho.Hj);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(openAssetFileDescriptor);
            }
        } else if (i == 7) {
            AssetFileDescriptor openAssetFileDescriptor2 = getContentResolver().openAssetFileDescriptor(this.Ho.uri, this.Ho.Hj, this.Ho.Hm);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(openAssetFileDescriptor2);
            }
        } else if (i == 8) {
            ParcelFileDescriptor openFile = getContentResolver().openFile(this.Ho.uri, this.Ho.Hj, this.Ho.Hm);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(openFile);
            }
        } else if (i == 9) {
            OutputStream openOutputStream = getContentResolver().openOutputStream(this.Ho.uri);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(openOutputStream);
            }
        } else if (i == 10) {
            OutputStream openOutputStream2 = getContentResolver().openOutputStream(this.Ho.uri, this.Ho.Hj);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(openOutputStream2);
            }
        } else if (i == 11) {
            AssetFileDescriptor openTypedAssetFile = getContentResolver().openTypedAssetFile(this.Ho.uri, this.Ho.mimeType, this.Ho.Hk, this.Ho.Hm);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(openTypedAssetFile);
            }
        } else if (i == 12) {
            AssetFileDescriptor openTypedAssetFileDescriptor = getContentResolver().openTypedAssetFileDescriptor(this.Ho.uri, this.Ho.mimeType, this.Ho.Hk);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(openTypedAssetFileDescriptor);
            }
        } else if (i == 13) {
            AssetFileDescriptor openTypedAssetFileDescriptor2 = getContentResolver().openTypedAssetFileDescriptor(this.Ho.uri, this.Ho.mimeType, this.Ho.Hk, this.Ho.Hm);
            if (this.Ho.Hn != null) {
                this.Ho.Hn.p(openTypedAssetFileDescriptor2);
            }
        }
    }
}
