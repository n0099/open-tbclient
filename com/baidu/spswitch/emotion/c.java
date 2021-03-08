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
    private static c cCC;
    private static Context mAppContext;
    private EditText cCD;
    private boolean cCE;
    private Runnable cCF = new Runnable() { // from class: com.baidu.spswitch.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.cCD.dispatchKeyEvent(new KeyEvent(0, 67));
            c.this.cCD.postDelayed(c.this.cCF, 60L);
        }
    };
    private a.InterfaceC0354a cCG;

    public static c bS(Context context) {
        mAppContext = context;
        if (cCC == null) {
            synchronized (c.class) {
                if (cCC == null) {
                    cCC = new c();
                }
            }
        }
        return cCC;
    }

    public AdapterView.OnItemClickListener a(final EmotionType emotionType, final int i) {
        return new AdapterView.OnItemClickListener() { // from class: com.baidu.spswitch.emotion.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Object adapter = adapterView.getAdapter();
                if (adapter instanceof BDEmotionBagLayout.a) {
                    BDEmotionBagLayout.a aVar = (BDEmotionBagLayout.a) adapter;
                    if (c.this.cCD != null) {
                        if (i2 == aVar.getCount() - 1) {
                            if (c.this.cCE) {
                                c.this.cCD.removeCallbacks(c.this.cCF);
                                c.this.cCE = false;
                                return;
                            }
                            c.this.cCD.dispatchKeyEvent(new KeyEvent(0, 67));
                            if (c.this.cCG != null) {
                                c.this.cCG.a(emotionType, i, "", "[delete]");
                                return;
                            }
                            return;
                        }
                        String item = aVar.getItem(i2);
                        if (!TextUtils.isEmpty(item)) {
                            c.this.cCD.getEditableText().insert(c.this.cCD.getSelectionStart(), a.afK().a(EmotionType.EMOTION_CLASSIC_TYPE, c.mAppContext, item, c.this.cCD));
                        }
                        if (c.this.cCG != null) {
                            c.this.cCG.a(emotionType, i, b.bP(c.mAppContext).b(emotionType, item), item);
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
                    c.this.cCE = true;
                    if (c.this.cCD != null) {
                        c.this.cCD.post(c.this.cCF);
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
                    c.this.afN();
                    return false;
                }
                return false;
            }
        };
    }

    public void afN() {
        if (this.cCD != null) {
            this.cCD.removeCallbacks(this.cCF);
        }
    }
}
