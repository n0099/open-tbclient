package com.baidu.swan.bdprivate.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.a.a;
import com.baidu.swan.apps.res.widget.a.b;
import com.baidu.swan.bdprivate.b;
import java.util.List;
/* loaded from: classes9.dex */
public class BdContextMenuView extends FrameLayout implements a.b {
    private static final boolean DEBUG = b.DEBUG;
    private a dXV;
    public boolean dXW;
    private Context mContext;
    private ListView mListView;
    private boolean mMenuLoaded;

    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    public BdContextMenuView(Context context) {
        super(context);
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    private void init() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setBackground(this.mContext.getResources().getDrawable(b.d.aiapps_context_menu_bg));
        this.mListView = new ListView(this.mContext);
        this.mListView.setCacheColorHint(0);
        this.mListView.setDivider(getResources().getDrawable(b.C0506b.aiapps_context_menu_divider_color));
        this.mListView.setDividerHeight(1);
        this.mListView.setSelector(new ColorDrawable(0));
        addView(this.mListView, new FrameLayout.LayoutParams(-1, -1));
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.bdprivate.widget.BdContextMenuView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BdContextMenuView.this.dXV.mh(i);
            }
        });
    }

    public void setLayoutInCenter(boolean z) {
        this.dXW = z;
    }

    /* loaded from: classes9.dex */
    private class a extends BaseAdapter {
        final /* synthetic */ BdContextMenuView dXX;
        private Context mContext;
        private List<com.baidu.swan.apps.res.widget.a.b> mDataList;

        /* renamed from: com.baidu.swan.bdprivate.widget.BdContextMenuView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0513a {
            public ImageView dXY;
            public TextView dXZ;

            public C0513a() {
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mDataList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.mDataList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"InflateParams"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0513a c0513a;
            View view2;
            if (view == null) {
                view2 = LayoutInflater.from(this.mContext).inflate(b.f.aiapps_menu_item_view, (ViewGroup) null);
                C0513a c0513a2 = new C0513a();
                c0513a2.dXY = (ImageView) view2.findViewById(b.e.item_icon);
                c0513a2.dXZ = (TextView) view2.findViewById(b.e.item_title);
                c0513a2.dXZ.setTextColor(this.mContext.getResources().getColor(b.C0506b.aiapps_context_menu_item_title_color));
                j(view2, i);
                view2.setTag(c0513a2);
                c0513a = c0513a2;
            } else {
                c0513a = (C0513a) view.getTag();
                view2 = view;
            }
            com.baidu.swan.apps.res.widget.a.b bVar = this.mDataList.get(i);
            c0513a.dXZ.setText(bVar.getTitle());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0513a.dXZ.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0513a.dXY.getLayoutParams();
            if (bVar.getIcon() != null) {
                c0513a.dXY.setVisibility(0);
                c0513a.dXY.setImageDrawable(bVar.getIcon());
                layoutParams.setMarginStart(this.mContext.getResources().getDimensionPixelSize(b.c.aiapps_context_menu_item_title_left_margin));
                c0513a.dXZ.setLayoutParams(layoutParams);
            } else {
                c0513a.dXY.setVisibility(8);
                layoutParams.setMarginStart(this.mContext.getResources().getDimensionPixelSize(b.c.aiapps_context_menu_item_icon_left_margin));
                c0513a.dXZ.setLayoutParams(layoutParams);
            }
            if (this.dXX.dXW) {
                ((LinearLayout) view2).setGravity(17);
                layoutParams.width = -2;
                if (bVar.getIcon() != null) {
                    layoutParams2.setMarginStart(0);
                    c0513a.dXY.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.setMarginStart(0);
                    c0513a.dXZ.setLayoutParams(layoutParams);
                }
            }
            return view2;
        }

        public void mh(int i) {
            com.baidu.swan.apps.res.widget.a.b bVar = this.mDataList.get(i);
            b.a aLJ = bVar.aLJ();
            if (aLJ != null) {
                aLJ.b(bVar);
            }
        }

        private void j(View view, int i) {
            if (getCount() == 1) {
                view.setBackground(this.mContext.getResources().getDrawable(b.d.aiapps_context_menu_round_corner_selector));
            } else if (i == 0) {
                view.setBackground(this.mContext.getResources().getDrawable(b.d.aiapps_context_menu_top_corner_selector));
            } else if (i == getCount() - 1) {
                view.setBackground(this.mContext.getResources().getDrawable(b.d.aiapps_context_menu_bottom_corner_selector));
            } else {
                view.setBackground(this.mContext.getResources().getDrawable(b.d.aiapps_context_menu_no_corner_selector));
            }
        }
    }
}
