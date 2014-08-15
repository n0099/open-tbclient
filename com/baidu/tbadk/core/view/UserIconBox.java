package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class UserIconBox extends LinearLayout {
    com.baidu.tbadk.imageManager.d a;
    private com.baidu.adp.lib.d.b<TbImageView> b;
    private z c;
    private Context d;
    private LinearLayout.LayoutParams e;

    public UserIconBox(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.a = new v(this);
        a(context);
    }

    public UserIconBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.a = new v(this);
        a(context);
    }

    private void a(Context context) {
        this.d = context;
        setOrientation(0);
        setGravity(16);
        if (this.d instanceof aa) {
            aa aaVar = (aa) this.d;
            this.b = aaVar.c();
            if (aaVar.a() != null && this.c == null) {
                this.c = new z(aaVar.c_());
                aaVar.a().setRecyclerListener(this.c);
            }
        }
        setOnHierarchyChangeListener(new x(this));
    }

    private LinearLayout.LayoutParams a(int i, int i2, int i3) {
        this.e = new LinearLayout.LayoutParams(i, i2);
        this.e.leftMargin = i3;
        return this.e;
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4, boolean z) {
        removeAllViews();
        if (list == null || list.size() != 1 || !TextUtils.isEmpty(list.get(0).getIcon())) {
            if (list != null && list.size() > 0) {
                LinearLayout.LayoutParams a = a(i2, i3, i4);
                LinearLayout.LayoutParams a2 = a(i2, i3, 0);
                setVisibility(0);
                for (int i5 = 0; i5 < i && i5 < list.size(); i5++) {
                    TbImageView b = b(this.d);
                    if (b != null) {
                        if (i5 == 0 && z) {
                            b.setLayoutParams(a2);
                        } else {
                            b.setLayoutParams(a);
                        }
                        b.setTag(list.get(i5).getIcon());
                        b.setClickable(false);
                        b.a(list.get(i5).getIcon(), 21, i2, i3, false);
                        addView(b);
                        b.invalidate();
                    }
                }
                return;
            }
            setVisibility(8);
        }
    }

    public void a(List<IconData> list, int i, int i2, int i3, int i4) {
        a(list, i, i2, i3, i4, false);
    }

    private TbImageView b(Context context) {
        TbImageView tbImageView = null;
        if (this.b != null) {
            tbImageView = this.b.a();
        }
        if (tbImageView == null || tbImageView.getParent() != null) {
            return new TbImageView(context);
        }
        return tbImageView;
    }

    public static com.baidu.adp.lib.d.b<TbImageView> a(Context context, int i) {
        return new com.baidu.adp.lib.d.b<>(new y(context), i, 0);
    }
}
