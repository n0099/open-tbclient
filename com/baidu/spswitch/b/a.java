package com.baidu.spswitch.b;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.baidu.spswitch.c;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.adapter.NoHorizontalScrollerVPAdapter;
import com.baidu.spswitch.emotion.fragment.EmotionClassicFragment;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static a aUZ;
    private FragmentActivity aUX;
    private EditText aUY;
    private boolean isNightMode;
    private List<Fragment> mFragments;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0182a {
        void onEmotionClick(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a DD() {
        if (aUZ == null) {
            synchronized (a.class) {
                if (aUZ == null) {
                    aUZ = new a();
                }
            }
        }
        return aUZ;
    }

    public void a(Activity activity, ViewGroup viewGroup, View view, boolean z) {
        if (!(viewGroup instanceof SPSwitchPanelLinearLayout)) {
            throw new IllegalArgumentException("panelLayout must be SPSwitchLinearLayout");
        }
        if (!(view instanceof EditText)) {
            throw new IllegalArgumentException("focus view must be EditText");
        }
        if (!(activity instanceof FragmentActivity)) {
            throw new IllegalArgumentException("host activity must be fragment activity");
        }
        this.aUX = (FragmentActivity) activity;
        this.isNightMode = z;
        h(viewGroup);
        this.mFragments = new ArrayList();
        this.mFragments.add(new EmotionClassicFragment());
        ((ViewPager) viewGroup.findViewById(c.C0183c.vp_emotion_type)).setAdapter(new NoHorizontalScrollerVPAdapter(getFragmentManager(), this.mFragments));
        this.aUY = (EditText) view;
        com.baidu.spswitch.emotion.c.bb(this.aUX.getApplicationContext()).a(this.aUY);
    }

    private void h(ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(c.C0183c.emotion_type_placeholer);
        View findViewById2 = viewGroup.findViewById(c.C0183c.emotion_type_layout);
        if (this.isNightMode) {
            findViewById.setBackgroundColor(-14540254);
            findViewById2.setBackgroundColor(-13421773);
            return;
        }
        findViewById.setBackgroundColor(-1);
        findViewById2.setBackgroundColor(-657931);
    }

    public void a(InterfaceC0182a interfaceC0182a) {
        com.baidu.spswitch.emotion.c.bb(this.aUX.getApplicationContext()).a(interfaceC0182a);
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }

    private FragmentManager getFragmentManager() {
        for (Fragment fragment : this.aUX.getSupportFragmentManager().getFragments()) {
            if (fragment instanceof DialogFragment) {
                return fragment.getChildFragmentManager();
            }
        }
        return this.aUX.getSupportFragmentManager();
    }

    public void dismiss() {
        if (this.aUX != null) {
            com.baidu.spswitch.emotion.c.bb(this.aUX.getApplicationContext()).dismiss();
        }
        aUZ = null;
    }
}
