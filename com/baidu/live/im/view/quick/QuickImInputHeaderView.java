package com.baidu.live.im.view.quick;

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
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.u.a;
import com.baidu.live.view.AlphaGradientHListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class QuickImInputHeaderView extends RelativeLayout {
    private AlphaGradientHListView avA;
    private b avB;
    private a avC;

    /* loaded from: classes3.dex */
    public interface a {
        void r(String str, int i);

        void xW();
    }

    public QuickImInputHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.avC = aVar;
    }

    public void setData(List<String> list) {
        if (this.avB == null) {
            this.avB = new b();
            this.avB.setData(list);
            this.avA.setAdapter((ListAdapter) this.avB);
        } else {
            this.avB.setData(list);
            this.avB.notifyDataSetChanged();
        }
        this.avA.setSelection(0);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_quick_im_input_header, (ViewGroup) this, true);
        this.avA = (AlphaGradientHListView) findViewById(a.g.lv);
        this.avA.setShadowWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        this.avA.setNeedAlphaShade(true);
        this.avA.setColor(getResources().getColor(a.d.sdk_white_alpha100), getResources().getColor(a.d.sdk_white_alpha0));
        this.avA.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        this.avA.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.im.view.quick.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.avC != null) {
                    QuickImInputHeaderView.this.avC.r(QuickImInputHeaderView.this.avB.getItem(i), i);
                }
            }
        });
        findViewById(a.g.iv_more).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.quick.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.avC != null) {
                    QuickImInputHeaderView.this.avC.xW();
                }
            }
        });
    }

    /* loaded from: classes3.dex */
    private static class b extends BaseAdapter {
        private List<String> avE;

        private b() {
        }

        public void setData(List<String> list) {
            if (this.avE == null) {
                this.avE = new ArrayList();
            }
            this.avE.clear();
            if (list != null) {
                this.avE.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.avE != null) {
                return this.avE.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.avE == null || getCount() <= i) ? "" : this.avE.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.ala_quick_im_input_header_item, (ViewGroup) null);
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

    /* loaded from: classes3.dex */
    private static class c {
        TextView textView;

        private c() {
        }
    }
}
