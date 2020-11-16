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
/* loaded from: classes15.dex */
public class GrantPermissionActivity extends Activity {
    private b HE;
    private int mRequestCode = -1;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.C0013a.activity_grant_permission);
        Intent intent = getIntent();
        this.mRequestCode = intent.getIntExtra("request_code", -1);
        this.HE = a.lf().bp(intent.getStringExtra("request_time_stamp"));
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
                W(i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (i2 == 0 && this.HE.HD != null) {
            this.HE.HD.ld();
        }
        a.lf().bo(String.valueOf(this.HE.timeStamp));
        finish();
    }

    private void W(int i) throws FileNotFoundException {
        if (i == 1) {
            int delete = getContentResolver().delete(this.HE.uri, this.HE.HB, this.HE.selectionArgs);
            if (this.HE.HD != null) {
                this.HE.HD.p(Integer.valueOf(delete));
            }
        } else if (i == 2) {
            int update = getContentResolver().update(this.HE.uri, this.HE.values, this.HE.HB, this.HE.selectionArgs);
            if (this.HE.HD != null) {
                this.HE.HD.p(Integer.valueOf(update));
            }
        } else if (i == 3) {
            ParcelFileDescriptor openFileDescriptor = getContentResolver().openFileDescriptor(this.HE.uri, this.HE.Hz);
            if (this.HE.HD != null) {
                this.HE.HD.p(openFileDescriptor);
            }
        } else if (i == 4) {
            ParcelFileDescriptor openFileDescriptor2 = getContentResolver().openFileDescriptor(this.HE.uri, this.HE.Hz, this.HE.HC);
            if (this.HE.HD != null) {
                this.HE.HD.p(openFileDescriptor2);
            }
        } else if (i == 5) {
            AssetFileDescriptor openAssetFile = getContentResolver().openAssetFile(this.HE.uri, this.HE.Hz, this.HE.HC);
            if (this.HE.HD != null) {
                this.HE.HD.p(openAssetFile);
            }
        } else if (i == 6) {
            AssetFileDescriptor openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(this.HE.uri, this.HE.Hz);
            if (this.HE.HD != null) {
                this.HE.HD.p(openAssetFileDescriptor);
            }
        } else if (i == 7) {
            AssetFileDescriptor openAssetFileDescriptor2 = getContentResolver().openAssetFileDescriptor(this.HE.uri, this.HE.Hz, this.HE.HC);
            if (this.HE.HD != null) {
                this.HE.HD.p(openAssetFileDescriptor2);
            }
        } else if (i == 8) {
            ParcelFileDescriptor openFile = getContentResolver().openFile(this.HE.uri, this.HE.Hz, this.HE.HC);
            if (this.HE.HD != null) {
                this.HE.HD.p(openFile);
            }
        } else if (i == 9) {
            OutputStream openOutputStream = getContentResolver().openOutputStream(this.HE.uri);
            if (this.HE.HD != null) {
                this.HE.HD.p(openOutputStream);
            }
        } else if (i == 10) {
            OutputStream openOutputStream2 = getContentResolver().openOutputStream(this.HE.uri, this.HE.Hz);
            if (this.HE.HD != null) {
                this.HE.HD.p(openOutputStream2);
            }
        } else if (i == 11) {
            AssetFileDescriptor openTypedAssetFile = getContentResolver().openTypedAssetFile(this.HE.uri, this.HE.mimeType, this.HE.HA, this.HE.HC);
            if (this.HE.HD != null) {
                this.HE.HD.p(openTypedAssetFile);
            }
        } else if (i == 12) {
            AssetFileDescriptor openTypedAssetFileDescriptor = getContentResolver().openTypedAssetFileDescriptor(this.HE.uri, this.HE.mimeType, this.HE.HA);
            if (this.HE.HD != null) {
                this.HE.HD.p(openTypedAssetFileDescriptor);
            }
        } else if (i == 13) {
            AssetFileDescriptor openTypedAssetFileDescriptor2 = getContentResolver().openTypedAssetFileDescriptor(this.HE.uri, this.HE.mimeType, this.HE.HA, this.HE.HC);
            if (this.HE.HD != null) {
                this.HE.HD.p(openTypedAssetFileDescriptor2);
            }
        }
    }
}
