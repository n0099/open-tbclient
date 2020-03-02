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
/* loaded from: classes13.dex */
public class a {
    private static a bae;
    private FragmentActivity bac;
    private EditText bad;
    private boolean isNightMode;
    private List<Fragment> mFragments;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0194a {
        void onEmotionClick(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a Gq() {
        if (bae == null) {
            synchronized (a.class) {
                if (bae == null) {
                    bae = new a();
                }
            }
        }
        return bae;
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
        this.bac = (FragmentActivity) activity;
        this.isNightMode = z;
        l(viewGroup);
        this.mFragments = new ArrayList();
        this.mFragments.add(new EmotionClassicFragment());
        ((ViewPager) viewGroup.findViewById(c.C0195c.vp_emotion_type)).setAdapter(new NoHorizontalScrollerVPAdapter(getFragmentManager(), this.mFragments));
        this.bad = (EditText) view;
        com.baidu.spswitch.emotion.c.bf(this.bac.getApplicationContext()).a(this.bad);
    }

    private void l(ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(c.C0195c.emotion_type_placeholer);
        View findViewById2 = viewGroup.findViewById(c.C0195c.emotion_type_layout);
        if (this.isNightMode) {
            findViewById.setBackgroundColor(-14540254);
            findViewById2.setBackgroundColor(-13421773);
            return;
        }
        findViewById.setBackgroundColor(-1);
        findViewById2.setBackgroundColor(-657931);
    }

    public void a(InterfaceC0194a interfaceC0194a) {
        com.baidu.spswitch.emotion.c.bf(this.bac.getApplicationContext()).a(interfaceC0194a);
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }

    private FragmentManager getFragmentManager() {
        for (Fragment fragment : this.bac.getSupportFragmentManager().getFragments()) {
            if (fragment instanceof DialogFragment) {
                return fragment.getChildFragmentManager();
            }
        }
        return this.bac.getSupportFragmentManager();
    }

    public void dismiss() {
        if (this.bac != null) {
            com.baidu.spswitch.emotion.c.bf(this.bac.getApplicationContext()).dismiss();
        }
        bae = null;
    }
}
