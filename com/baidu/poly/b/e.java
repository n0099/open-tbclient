package com.baidu.poly.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class e extends Handler {
    public e() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        f fVar = (f) message.obj;
        ImageView imageView = fVar.agD;
        if (((String) imageView.getTag()).equals(fVar.url)) {
            imageView.setImageBitmap(fVar.bitmap);
        } else {
            Log.i("ImageTaskHandler", "不是最新数据");
        }
    }
}
