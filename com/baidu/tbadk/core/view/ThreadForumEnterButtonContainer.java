package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public final int f12365e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadForumEnterButton f12366f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadForumEnterButton f12367g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadForumEnterButton f12368h;

    /* renamed from: i  reason: collision with root package name */
    public View f12369i;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public void a() {
        ThreadForumEnterButton threadForumEnterButton = this.f12366f;
        if (threadForumEnterButton != null) {
            threadForumEnterButton.d();
        }
        ThreadForumEnterButton threadForumEnterButton2 = this.f12367g;
        if (threadForumEnterButton2 != null) {
            threadForumEnterButton2.d();
        }
        ThreadForumEnterButton threadForumEnterButton3 = this.f12368h;
        if (threadForumEnterButton3 != null) {
            threadForumEnterButton3.d();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        ThreadForumEnterButton threadForumEnterButton = this.f12366f;
        if (threadForumEnterButton != null) {
            threadForumEnterButton.setAfterClickListener(onClickListener);
        }
        ThreadForumEnterButton threadForumEnterButton2 = this.f12367g;
        if (threadForumEnterButton2 != null) {
            threadForumEnterButton2.setAfterClickListener(onClickListener);
        }
        ThreadForumEnterButton threadForumEnterButton3 = this.f12368h;
        if (threadForumEnterButton3 != null) {
            threadForumEnterButton3.setAfterClickListener(onClickListener);
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.f12369i.setVisibility(z ? 0 : 8);
    }

    public void setFrom(int i2) {
        ThreadForumEnterButton threadForumEnterButton = this.f12366f;
        if (threadForumEnterButton != null) {
            threadForumEnterButton.setFrom(i2);
        }
        ThreadForumEnterButton threadForumEnterButton2 = this.f12367g;
        if (threadForumEnterButton2 != null) {
            threadForumEnterButton2.setFrom(i2);
        }
        ThreadForumEnterButton threadForumEnterButton3 = this.f12368h;
        if (threadForumEnterButton3 != null) {
            threadForumEnterButton3.setFrom(i2);
        }
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12365e = l.g(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.f12366f = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.f12367g = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.f12368h = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.f12369i = findViewById(R.id.bottom_placeholder);
        int k = (((l.k(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.f12365e) / 2;
        int k2 = (((l.k(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.f12365e * 2)) / 3;
    }
}
