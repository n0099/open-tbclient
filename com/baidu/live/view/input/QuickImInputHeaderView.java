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
import com.baidu.live.k.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class QuickImInputHeaderView extends RelativeLayout {
    private AlphaGradientHListView asV;
    private b asW;
    private a asX;

    /* loaded from: classes6.dex */
    public interface a {
        void n(String str, int i);

        void tL();
    }

    public QuickImInputHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.asX = aVar;
    }

    public void setData(List<String> list) {
        if (this.asW == null) {
            this.asW = new b();
            this.asW.setData(list);
            this.asV.setAdapter((ListAdapter) this.asW);
        } else {
            this.asW.setData(list);
            this.asW.notifyDataSetChanged();
        }
        this.asV.setSelection(0);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.sdk_quick_im_input_header, (ViewGroup) this, true);
        this.asV = (AlphaGradientHListView) findViewById(a.g.lv);
        this.asV.setShadowWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        this.asV.setNeedAlphaShade(true);
        this.asV.setColor(getResources().getColor(a.d.sdk_white_alpha100), getResources().getColor(a.d.sdk_white_alpha0));
        this.asV.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        this.asV.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.view.input.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.asX != null) {
                    QuickImInputHeaderView.this.asX.n(QuickImInputHeaderView.this.asW.getItem(i), i);
                }
            }
        });
        findViewById(a.g.iv_more).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.input.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.asX != null) {
                    QuickImInputHeaderView.this.asX.tL();
                }
            }
        });
    }

    /* loaded from: classes6.dex */
    private static class b extends BaseAdapter {
        private List<String> asZ;

        private b() {
        }

        public void setData(List<String> list) {
            if (this.asZ == null) {
                this.asZ = new ArrayList();
            }
            this.asZ.clear();
            if (list != null) {
                this.asZ.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.asZ != null) {
                return this.asZ.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.asZ == null || getCount() <= i) ? "" : this.asZ.get(i);
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

    /* loaded from: classes6.dex */
    private static class c {
        TextView textView;

        private c() {
        }
    }
}
