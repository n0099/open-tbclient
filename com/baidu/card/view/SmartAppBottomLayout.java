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
import d.b.c.e.p.l;
import d.b.i.p;
import d.b.i0.r.q.a;
import d.b.i0.r.q.a2;
/* loaded from: classes.dex */
public class SmartAppBottomLayout extends LinearLayout implements p<a> {
    public static final int i = (l.k(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds58);

    /* renamed from: e  reason: collision with root package name */
    public View f4557e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f4558f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4559g;

    /* renamed from: h  reason: collision with root package name */
    public int f4560h;

    public SmartAppBottomLayout(Context context) {
        this(context, null);
        b(context);
    }

    public final void b(Context context) {
        this.f4557e = LayoutInflater.from(context).inflate(R.layout.smart_app_bottom_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4558f = (HeadImageView) this.f4557e.findViewById(R.id.ai_smart_app_icon);
        this.f4559g = (TextView) this.f4557e.findViewById(R.id.ai_smart_app_text);
        this.f4558f.setIsBigV(false);
        this.f4558f.setIsGod(false);
        this.f4558f.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: c */
    public void a(a aVar) {
        a2 n = aVar.n();
        if (n == null || n.j1() == null) {
            return;
        }
        if (!TextUtils.isEmpty(n.j1().avatar)) {
            this.f4558f.W(n.j1().avatar, 10, false);
        } else {
            SkinManager.setImageResource(this.f4558f, R.drawable.icon_avatar_smallapp_tie);
        }
        if (n.j1() != null && !TextUtils.isEmpty(n.j1().name)) {
            ThreadCardUtils.cutAndSetTextByMaxLine(this.f4559g, n.j1().name, R.string.ai_smart_app, R.dimen.tbds0, 1, i, false);
        } else {
            this.f4559g.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
        }
    }

    public void d() {
        if (this.f4560h != TbadkCoreApplication.getInst().getSkinType()) {
            this.f4560h = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setViewTextColor(this.f4559g, R.color.CAM_X0109);
        }
    }

    public SmartAppBottomLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4560h = 3;
        b(context);
    }
}
