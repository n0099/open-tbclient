package com.baidu.nadcore.widget.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedVideoBaseView;
import com.baidu.tieba.R;
import com.baidu.tieba.n21;
import com.baidu.tieba.nn0;
import com.baidu.tieba.r81;
import com.baidu.tieba.s81;
import com.baidu.tieba.sm0;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class NadRewardBaseView extends AdFeedVideoBaseView {
    public WeakReference<Activity> i;
    public s81 j;
    public boolean k;

    @Override // com.baidu.nadcore.widget.feed.AdFeedVideoBaseView, com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void b() {
    }

    public abstract void h(LayoutInflater layoutInflater, nn0 nn0Var);

    public abstract void i(Context context);

    /* loaded from: classes3.dex */
    public class a implements r81.d {
        public a() {
        }

        @Override // com.baidu.tieba.r81.d
        public void a(List<sm0.a> list) {
            Toast.makeText(NadRewardBaseView.this.getContext(), (int) R.string.nad_dislike_reduce_recommend, 0).show();
            NadRewardBaseView.this.k = true;
        }
    }

    public NadRewardBaseView(Context context) {
        this(context, null);
    }

    public void f(Context context) {
        i(context);
    }

    public void setRewardMediaListener(s81 s81Var) {
        this.j = s81Var;
    }

    public NadRewardBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        super.onVisibilityChanged(view2, i);
        if (i == 0) {
            g();
        }
    }

    public NadRewardBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadRewardBaseView(Context context, AttributeSet attributeSet, int i, nn0 nn0Var) {
        super(context, attributeSet, i, nn0Var);
        setFocusable(true);
        setFocusableInTouchMode(true);
        h(LayoutInflater.from(context), nn0Var);
        f(context);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void e() {
        if (this.k) {
            Toast.makeText(getContext(), (int) R.string.nad_dislike_reduce_repeat, 0).show();
            if (this.c != null) {
                this.c = null;
                return;
            }
            return;
        }
        if (this.c == null) {
            if (!(getTag() instanceof AdBaseModel)) {
                return;
            }
            this.c = new r81(getContext(), (AdBaseModel) getTag());
        }
        this.c.h(new a());
        this.c.i();
    }

    public void g() {
        WeakReference<Activity> weakReference = this.i;
        if (weakReference != null && weakReference.get() != null) {
            n21.a(this.i.get().getWindow());
        }
    }
}
