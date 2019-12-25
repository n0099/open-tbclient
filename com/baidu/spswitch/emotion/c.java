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
/* loaded from: classes11.dex */
public class c {
    private static c aUu;
    private static Context mAppContext;
    private boolean aUv;
    private Runnable aUw = new Runnable() { // from class: com.baidu.spswitch.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.mEditText.dispatchKeyEvent(new KeyEvent(0, 67));
            c.this.mEditText.postDelayed(c.this.aUw, 60L);
        }
    };
    private a.InterfaceC0182a aUx;
    private EditText mEditText;

    public static c bb(Context context) {
        mAppContext = context;
        if (aUu == null) {
            synchronized (c.class) {
                if (aUu == null) {
                    aUu = new c();
                }
            }
        }
        return aUu;
    }

    public void a(EditText editText) {
        this.mEditText = editText;
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
                            if (c.this.aUv) {
                                c.this.mEditText.removeCallbacks(c.this.aUw);
                                c.this.aUv = false;
                                return;
                            }
                            c.this.mEditText.dispatchKeyEvent(new KeyEvent(0, 67));
                            if (c.this.aUx != null) {
                                c.this.aUx.onEmotionClick(emotionType, i, "", "[delete]");
                                return;
                            }
                            return;
                        }
                        String item = aVar.getItem(i2);
                        if (!TextUtils.isEmpty(item)) {
                            c.this.mEditText.getEditableText().insert(c.this.mEditText.getSelectionStart(), a.Dw().a(EmotionType.EMOTION_CLASSIC_TYPE, c.mAppContext, item, c.this.mEditText));
                        }
                        if (c.this.aUx != null) {
                            c.this.aUx.onEmotionClick(emotionType, i, b.aY(c.mAppContext).b(emotionType, item), item);
                        }
                    }
                }
            }
        };
    }

    public AdapterView.OnItemLongClickListener b(EmotionType emotionType) {
        return new AdapterView.OnItemLongClickListener() { // from class: com.baidu.spswitch.emotion.c.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object adapter = adapterView.getAdapter();
                if ((adapter instanceof BDEmotionBagLayout.a) && i == ((BDEmotionBagLayout.a) adapter).getCount() - 1) {
                    c.this.aUv = true;
                    if (c.this.mEditText != null) {
                        c.this.mEditText.post(c.this.aUw);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        };
    }

    public View.OnTouchListener c(EmotionType emotionType) {
        return new View.OnTouchListener() { // from class: com.baidu.spswitch.emotion.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    c.this.Dz();
                    return false;
                }
                return false;
            }
        };
    }

    public void a(a.InterfaceC0182a interfaceC0182a) {
        this.aUx = interfaceC0182a;
    }

    public void Dz() {
        if (this.mEditText != null) {
            this.mEditText.removeCallbacks(this.aUw);
        }
    }

    public void dismiss() {
        this.mEditText = null;
        mAppContext = null;
        aUu = null;
    }
}
