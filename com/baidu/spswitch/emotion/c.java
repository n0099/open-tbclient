package com.baidu.spswitch.emotion;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.baidu.spswitch.b.a;
import com.baidu.spswitch.emotion.view.BDEmotionBagLayout;
/* loaded from: classes3.dex */
public class c {
    private static c cDs;
    private static Context mAppContext;
    private EditText cDt;
    private boolean cDu;
    private Runnable cDv = new Runnable() { // from class: com.baidu.spswitch.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.cDt.dispatchKeyEvent(new KeyEvent(0, 67));
            c.this.cDt.postDelayed(c.this.cDv, 60L);
        }
    };
    private a.InterfaceC0368a cDw;

    public static c bV(Context context) {
        mAppContext = context;
        if (cDs == null) {
            synchronized (c.class) {
                if (cDs == null) {
                    cDs = new c();
                }
            }
        }
        return cDs;
    }

    public AdapterView.OnItemClickListener a(final EmotionType emotionType, final int i) {
        return new AdapterView.OnItemClickListener() { // from class: com.baidu.spswitch.emotion.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Object adapter = adapterView.getAdapter();
                if (adapter instanceof BDEmotionBagLayout.a) {
                    BDEmotionBagLayout.a aVar = (BDEmotionBagLayout.a) adapter;
                    if (c.this.cDt != null) {
                        if (i2 == aVar.getCount() - 1) {
                            if (c.this.cDu) {
                                c.this.cDt.removeCallbacks(c.this.cDv);
                                c.this.cDu = false;
                                return;
                            }
                            c.this.cDt.dispatchKeyEvent(new KeyEvent(0, 67));
                            if (c.this.cDw != null) {
                                c.this.cDw.a(emotionType, i, "", "[delete]");
                                return;
                            }
                            return;
                        }
                        String item = aVar.getItem(i2);
                        if (!TextUtils.isEmpty(item)) {
                            c.this.cDt.getEditableText().insert(c.this.cDt.getSelectionStart(), a.ajb().a(EmotionType.EMOTION_CLASSIC_TYPE, c.mAppContext, item, c.this.cDt));
                        }
                        if (c.this.cDw != null) {
                            c.this.cDw.a(emotionType, i, b.bS(c.mAppContext).b(emotionType, item), item);
                        }
                    }
                }
            }
        };
    }

    public AdapterView.OnItemLongClickListener a(EmotionType emotionType) {
        return new AdapterView.OnItemLongClickListener() { // from class: com.baidu.spswitch.emotion.c.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object adapter = adapterView.getAdapter();
                if ((adapter instanceof BDEmotionBagLayout.a) && i == ((BDEmotionBagLayout.a) adapter).getCount() - 1) {
                    c.this.cDu = true;
                    if (c.this.cDt != null) {
                        c.this.cDt.post(c.this.cDv);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        };
    }

    public View.OnTouchListener b(EmotionType emotionType) {
        return new View.OnTouchListener() { // from class: com.baidu.spswitch.emotion.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    c.this.aje();
                    return false;
                }
                return false;
            }
        };
    }

    public void aje() {
        if (this.cDt != null) {
            this.cDt.removeCallbacks(this.cDv);
        }
    }
}
