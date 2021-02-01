package com.baidu.live.widget;

import android.app.Activity;
import android.view.View;
import com.baidu.h.a.d.a;
import com.baidu.live.ah.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class a implements com.baidu.h.a.d.a {
    private int bXo;
    private int bXp;

    @Override // com.baidu.h.a.d.a
    public void a(Activity activity, a.InterfaceC0117a interfaceC0117a) {
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        this.bXo = inst.getResources().getDimensionPixelSize(a.C0157a.like_explosion_size);
        this.bXp = inst.getResources().getDimensionPixelSize(a.C0157a.like_heart_size);
        HeartSurfaceView2 heartSurfaceView2 = new HeartSurfaceView2(inst);
        heartSurfaceView2.setZOrderOnTop(true);
        heartSurfaceView2.getHolder().setFormat(-3);
        interfaceC0117a.b(0, heartSurfaceView2);
    }

    @Override // com.baidu.h.a.d.a
    public void i(View view, int i) {
        if (view instanceof HeartSurfaceView2) {
            view.setVisibility(0);
            ((HeartSurfaceView2) view).addHeart(i);
        }
    }
}
