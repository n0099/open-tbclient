package com.baidu.cloudsdk.common.imgloader;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class CompressBitmapTask extends AsyncTask {
    private Context a;
    private ICompressBitmapListener b;

    /* loaded from: classes.dex */
    public interface ICompressBitmapListener {
        void onComplete(ByteArrayOutputStream byteArrayOutputStream);
    }

    public CompressBitmapTask(Context context, ICompressBitmapListener iCompressBitmapListener) {
        this.a = context;
        this.b = iCompressBitmapListener;
    }

    private InputStream a(Uri uri) {
        InputStream inputStream = null;
        try {
            if (uri.getScheme() == null) {
                inputStream = new FileInputStream(new File(uri.toString()));
            } else if ((uri.getScheme().equalsIgnoreCase(PushConstants.EXTRA_CONTENT) || uri.getScheme().equalsIgnoreCase("file")) && this.a != null) {
                inputStream = this.a.getContentResolver().openInputStream(uri);
            }
        } catch (IOException e) {
            Log.e("CompressBitmap", "IOexception");
            e.printStackTrace();
        }
        return inputStream;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public ByteArrayOutputStream doInBackground(Uri... uriArr) {
        InputStream a;
        if (uriArr[0] == null || (a = a(uriArr[0])) == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = a.read(bArr);
                if (read == -1) {
                    a.close();
                    return byteArrayOutputStream;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                e.printStackTrace();
                return byteArrayOutputStream;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(ByteArrayOutputStream byteArrayOutputStream) {
        if (this.b != null) {
            this.b.onComplete(byteArrayOutputStream);
        }
    }
}
