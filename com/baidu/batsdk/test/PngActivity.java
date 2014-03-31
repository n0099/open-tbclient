package com.baidu.batsdk.test;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.batsdk.BatSDK;
import com.baidu.batsdk.f.b;
import com.slidingmenu.lib.R;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public class PngActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_add_item);
        try {
            FileInputStream openFileInput = openFileInput("logo36px.png");
            String a = b.a(com.baidu.batsdk.b.b.a(openFileInput), 0);
            FileOutputStream openFileOutput = openFileOutput("logo36px.base64", 0);
            openFileOutput.write(a.getBytes("US-ASCII"));
            openFileOutput.close();
            openFileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        BatSDK.doActivityStart(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        BatSDK.doActivityStop(this);
    }
}
