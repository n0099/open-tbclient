package com.baidu.cloudsdk.common.imgloader;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
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
        try {
        } catch (IOException e) {
            Log.e("CompressBitmap", "IOexception");
            e.printStackTrace();
        }
        if (uri.getScheme() == null) {
            return new FileInputStream(new File(uri.toString()));
        }
        if ((uri.getScheme().equalsIgnoreCase(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT) || uri.getScheme().equalsIgnoreCase("file")) && this.a != null) {
            return this.a.getContentResolver().openInputStream(uri);
        }
        return null;
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
