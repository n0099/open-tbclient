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
    private static c cBc;
    private static Context mAppContext;
    private EditText cBd;
    private boolean cBe;
    private Runnable cBf = new Runnable() { // from class: com.baidu.spswitch.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.cBd.dispatchKeyEvent(new KeyEvent(0, 67));
            c.this.cBd.postDelayed(c.this.cBf, 60L);
        }
    };
    private a.InterfaceC0348a cBg;

    public static c bT(Context context) {
        mAppContext = context;
        if (cBc == null) {
            synchronized (c.class) {
                if (cBc == null) {
                    cBc = new c();
                }
            }
        }
        return cBc;
    }

    public AdapterView.OnItemClickListener a(final EmotionType emotionType, final int i) {
        return new AdapterView.OnItemClickListener() { // from class: com.baidu.spswitch.emotion.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Object adapter = adapterView.getAdapter();
                if (adapter instanceof BDEmotionBagLayout.a) {
                    BDEmotionBagLayout.a aVar = (BDEmotionBagLayout.a) adapter;
                    if (c.this.cBd != null) {
                        if (i2 == aVar.getCount() - 1) {
                            if (c.this.cBe) {
                                c.this.cBd.removeCallbacks(c.this.cBf);
                                c.this.cBe = false;
                                return;
                            }
                            c.this.cBd.dispatchKeyEvent(new KeyEvent(0, 67));
                            if (c.this.cBg != null) {
                                c.this.cBg.a(emotionType, i, "", "[delete]");
                                return;
                            }
                            return;
                        }
                        String item = aVar.getItem(i2);
                        if (!TextUtils.isEmpty(item)) {
                            c.this.cBd.getEditableText().insert(c.this.cBd.getSelectionStart(), a.afH().a(EmotionType.EMOTION_CLASSIC_TYPE, c.mAppContext, item, c.this.cBd));
                        }
                        if (c.this.cBg != null) {
                            c.this.cBg.a(emotionType, i, b.bQ(c.mAppContext).b(emotionType, item), item);
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
                    c.this.cBe = true;
                    if (c.this.cBd != null) {
                        c.this.cBd.post(c.this.cBf);
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
                    c.this.afK();
                    return false;
                }
                return false;
            }
        };
    }

    public void afK() {
        if (this.cBd != null) {
            this.cBd.removeCallbacks(this.cBf);
        }
    }
}
