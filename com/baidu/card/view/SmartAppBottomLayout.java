package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.j0.r.q.a;
import d.a.j0.r.q.a2;
/* loaded from: classes.dex */
public class SmartAppBottomLayout extends LinearLayout implements p<a> {

    /* renamed from: i  reason: collision with root package name */
    public static final int f4511i = (l.k(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds58);

    /* renamed from: e  reason: collision with root package name */
    public View f4512e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f4513f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4514g;

    /* renamed from: h  reason: collision with root package name */
    public int f4515h;

    public SmartAppBottomLayout(Context context) {
        this(context, null);
        b(context);
    }

    public final void b(Context context) {
        this.f4512e = LayoutInflater.from(context).inflate(R.layout.smart_app_bottom_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4513f = (HeadImageView) this.f4512e.findViewById(R.id.ai_smart_app_icon);
        this.f4514g = (TextView) this.f4512e.findViewById(R.id.ai_smart_app_text);
        this.f4513f.setIsBigV(false);
        this.f4513f.setIsGod(false);
        this.f4513f.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: c */
    public void a(a aVar) {
        a2 m = aVar.m();
        if (m == null || m.j1() == null) {
            return;
        }
        if (!TextUtils.isEmpty(m.j1().avatar)) {
            this.f4513f.V(m.j1().avatar, 10, false);
        } else {
            SkinManager.setImageResource(this.f4513f, R.drawable.icon_avatar_smallapp_tie);
        }
        if (m.j1() != null && !TextUtils.isEmpty(m.j1().name)) {
            ThreadCardUtils.cutAndSetTextByMaxLine(this.f4514g, m.j1().name, R.string.ai_smart_app, R.dimen.tbds0, 1, f4511i, false);
        } else {
            this.f4514g.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
        }
    }

    public void d() {
        if (this.f4515h != TbadkCoreApplication.getInst().getSkinType()) {
            this.f4515h = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setViewTextColor(this.f4514g, R.color.CAM_X0109);
        }
    }

    public SmartAppBottomLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4515h = 3;
        b(context);
    }
}
