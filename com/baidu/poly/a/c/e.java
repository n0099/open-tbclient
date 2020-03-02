package com.baidu.poly.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class e extends Handler {
    public e() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        f fVar = (f) message.obj;
        ImageView imageView = fVar.aQx;
        if (((String) imageView.getTag()).equals(fVar.url)) {
            imageView.setImageBitmap(fVar.bitmap);
        } else {
            com.baidu.poly.util.c.info("不是最新数据");
        }
    }
}
