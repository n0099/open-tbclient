package com.baidu.poly.a.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class e extends Handler {
    public e() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        f fVar = (f) message.obj;
        ImageView imageView = fVar.bFc;
        if (((String) imageView.getTag()).equals(fVar.url)) {
            imageView.setImageBitmap(fVar.bitmap);
        } else {
            com.baidu.poly.util.d.info("不是最新数据");
        }
    }
}
