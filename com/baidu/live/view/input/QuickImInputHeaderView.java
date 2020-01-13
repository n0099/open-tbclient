package com.baidu.live.view.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class QuickImInputHeaderView extends RelativeLayout {
    private AlphaGradientHListView aBC;
    private b aBD;
    private a aBE;

    /* loaded from: classes2.dex */
    public interface a {
        void r(String str, int i);

        void vY();
    }

    public QuickImInputHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.aBE = aVar;
    }

    public void setData(List<String> list) {
        if (this.aBD == null) {
            this.aBD = new b();
            this.aBD.setData(list);
            this.aBC.setAdapter((ListAdapter) this.aBD);
        } else {
            this.aBD.setData(list);
            this.aBD.notifyDataSetChanged();
        }
        this.aBC.setSelection(0);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.sdk_quick_im_input_header, (ViewGroup) this, true);
        this.aBC = (AlphaGradientHListView) findViewById(a.g.lv);
        this.aBC.setShadowWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        this.aBC.setNeedAlphaShade(true);
        this.aBC.setColor(getResources().getColor(a.d.sdk_white_alpha100), getResources().getColor(a.d.sdk_white_alpha0));
        this.aBC.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        this.aBC.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.view.input.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.aBE != null) {
                    QuickImInputHeaderView.this.aBE.r(QuickImInputHeaderView.this.aBD.getItem(i), i);
                }
            }
        });
        findViewById(a.g.iv_more).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.input.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.aBE != null) {
                    QuickImInputHeaderView.this.aBE.vY();
                }
            }
        });
    }

    /* loaded from: classes2.dex */
    private static class b extends BaseAdapter {
        private List<String> aBG;

        private b() {
        }

        public void setData(List<String> list) {
            if (this.aBG == null) {
                this.aBG = new ArrayList();
            }
            this.aBG.clear();
            if (list != null) {
                this.aBG.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aBG != null) {
                return this.aBG.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.aBG == null || getCount() <= i) ? "" : this.aBG.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.sdk_quick_im_input_header_item, (ViewGroup) null);
                c cVar2 = new c();
                cVar2.textView = (TextView) view.findViewById(a.g.tv);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.textView.setText(getItem(i));
            ((FrameLayout.LayoutParams) cVar.textView.getLayoutParams()).rightMargin = viewGroup.getResources().getDimensionPixelOffset(i == getCount() + (-1) ? a.e.sdk_ds48 : a.e.sdk_ds16);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class c {
        TextView textView;

        private c() {
        }
    }
}
