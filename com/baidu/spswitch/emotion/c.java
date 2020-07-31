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
    private static c bLf;
    private static Context mAppContext;
    private boolean bLg;
    private Runnable bLh = new Runnable() { // from class: com.baidu.spswitch.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.mEditText.dispatchKeyEvent(new KeyEvent(0, 67));
            c.this.mEditText.postDelayed(c.this.bLh, 60L);
        }
    };
    private a.InterfaceC0287a bLi;
    private EditText mEditText;

    public static c aW(Context context) {
        mAppContext = context;
        if (bLf == null) {
            synchronized (c.class) {
                if (bLf == null) {
                    bLf = new c();
                }
            }
        }
        return bLf;
    }

    public AdapterView.OnItemClickListener a(final EmotionType emotionType, final int i) {
        return new AdapterView.OnItemClickListener() { // from class: com.baidu.spswitch.emotion.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Object adapter = adapterView.getAdapter();
                if (adapter instanceof BDEmotionBagLayout.a) {
                    BDEmotionBagLayout.a aVar = (BDEmotionBagLayout.a) adapter;
                    if (c.this.mEditText != null) {
                        if (i2 == aVar.getCount() - 1) {
                            if (c.this.bLg) {
                                c.this.mEditText.removeCallbacks(c.this.bLh);
                                c.this.bLg = false;
                                return;
                            }
                            c.this.mEditText.dispatchKeyEvent(new KeyEvent(0, 67));
                            if (c.this.bLi != null) {
                                c.this.bLi.a(emotionType, i, "", "[delete]");
                                return;
                            }
                            return;
                        }
                        String item = aVar.getItem(i2);
                        if (!TextUtils.isEmpty(item)) {
                            c.this.mEditText.getEditableText().insert(c.this.mEditText.getSelectionStart(), a.RI().a(EmotionType.EMOTION_CLASSIC_TYPE, c.mAppContext, item, c.this.mEditText));
                        }
                        if (c.this.bLi != null) {
                            c.this.bLi.a(emotionType, i, b.aT(c.mAppContext).b(emotionType, item), item);
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
                    c.this.bLg = true;
                    if (c.this.mEditText != null) {
                        c.this.mEditText.post(c.this.bLh);
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
                    c.this.RL();
                    return false;
                }
                return false;
            }
        };
    }

    public void RL() {
        if (this.mEditText != null) {
            this.mEditText.removeCallbacks(this.bLh);
        }
    }
}
