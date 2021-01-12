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
    private static c cyG;
    private static Context mAppContext;
    private EditText cyH;
    private boolean cyI;
    private Runnable cyJ = new Runnable() { // from class: com.baidu.spswitch.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.cyH.dispatchKeyEvent(new KeyEvent(0, 67));
            c.this.cyH.postDelayed(c.this.cyJ, 60L);
        }
    };
    private a.InterfaceC0351a cyK;

    public static c bU(Context context) {
        mAppContext = context;
        if (cyG == null) {
            synchronized (c.class) {
                if (cyG == null) {
                    cyG = new c();
                }
            }
        }
        return cyG;
    }

    public AdapterView.OnItemClickListener a(final EmotionType emotionType, final int i) {
        return new AdapterView.OnItemClickListener() { // from class: com.baidu.spswitch.emotion.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Object adapter = adapterView.getAdapter();
                if (adapter instanceof BDEmotionBagLayout.a) {
                    BDEmotionBagLayout.a aVar = (BDEmotionBagLayout.a) adapter;
                    if (c.this.cyH != null) {
                        if (i2 == aVar.getCount() - 1) {
                            if (c.this.cyI) {
                                c.this.cyH.removeCallbacks(c.this.cyJ);
                                c.this.cyI = false;
                                return;
                            }
                            c.this.cyH.dispatchKeyEvent(new KeyEvent(0, 67));
                            if (c.this.cyK != null) {
                                c.this.cyK.a(emotionType, i, "", "[delete]");
                                return;
                            }
                            return;
                        }
                        String item = aVar.getItem(i2);
                        if (!TextUtils.isEmpty(item)) {
                            c.this.cyH.getEditableText().insert(c.this.cyH.getSelectionStart(), a.afi().a(EmotionType.EMOTION_CLASSIC_TYPE, c.mAppContext, item, c.this.cyH));
                        }
                        if (c.this.cyK != null) {
                            c.this.cyK.a(emotionType, i, b.bR(c.mAppContext).b(emotionType, item), item);
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
                    c.this.cyI = true;
                    if (c.this.cyH != null) {
                        c.this.cyH.post(c.this.cyJ);
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
                    c.this.afl();
                    return false;
                }
                return false;
            }
        };
    }

    public void afl() {
        if (this.cyH != null) {
            this.cyH.removeCallbacks(this.cyJ);
        }
    }
}
