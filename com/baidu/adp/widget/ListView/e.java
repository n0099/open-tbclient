package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.af;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e {
    public a Vp = null;
    public ArrayList<c> mFooterViewInfos;
    public ArrayList<c> mHeaderViewInfos;

    /* loaded from: classes.dex */
    public interface a {
        void onPreLoad();
    }

    public e() {
        this.mHeaderViewInfos = null;
        this.mFooterViewInfos = null;
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
    }

    public void a(a aVar) {
        this.Vp = aVar;
    }

    public int z(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mHeaderViewInfos.size()) {
                c cVar = this.mHeaderViewInfos.get(i2);
                if (cVar == null || cVar.Vr == null || cVar.Vr.itemView != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return -1;
            }
        }
    }

    public int A(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mFooterViewInfos.size()) {
                c cVar = this.mFooterViewInfos.get(i2);
                if (cVar == null || cVar.Vr == null || cVar.Vr.itemView != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return -1;
            }
        }
    }

    public int getHeadersCount() {
        return this.mHeaderViewInfos.size();
    }

    public int getFootersCount() {
        return this.mFooterViewInfos.size();
    }

    public void addHeaderView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            c cVar = new c();
            cVar.Vr = new af.a(view);
            cVar.data = obj;
            cVar.isSelectable = z;
            cVar.type = BdUniqueId.gen().getId();
            cVar.id = cVar.type;
            view.setTag("HEADER");
            if (i < 0 || i > this.mHeaderViewInfos.size()) {
                this.mHeaderViewInfos.add(cVar);
            } else {
                this.mHeaderViewInfos.add(i, cVar);
            }
        }
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            c cVar = new c();
            cVar.Vr = new af.a(view);
            cVar.data = obj;
            cVar.isSelectable = z;
            cVar.type = BdUniqueId.gen().getId();
            cVar.id = cVar.type;
            view.setTag("FOOTER");
            if (i < 0 || i > this.mFooterViewInfos.size()) {
                this.mFooterViewInfos.add(cVar);
            } else {
                this.mFooterViewInfos.add(i, cVar);
            }
        }
    }

    public boolean removeHeader(View view) {
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.mHeaderViewInfos.size(); i++) {
            c cVar = this.mHeaderViewInfos.get(i);
            if (cVar != null && cVar.Vr != null && cVar.Vr.itemView == view) {
                this.mHeaderViewInfos.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeFooter(View view) {
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.mFooterViewInfos.size(); i++) {
            c cVar = this.mFooterViewInfos.get(i);
            if (cVar != null && cVar.Vr != null && cVar.Vr.itemView == view) {
                this.mFooterViewInfos.remove(i);
                return true;
            }
        }
        return false;
    }

    public af.a aM(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHeaderViewInfos.size()) {
                if (this.mHeaderViewInfos.get(i3) == null || i != this.mHeaderViewInfos.get(i3).type) {
                    i2 = i3 + 1;
                } else {
                    return this.mHeaderViewInfos.get(i3).Vr;
                }
            } else {
                return null;
            }
        }
    }

    public af.a aN(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mFooterViewInfos.size()) {
                if (this.mFooterViewInfos.get(i3) == null || i != this.mFooterViewInfos.get(i3).type) {
                    i2 = i3 + 1;
                } else {
                    return this.mFooterViewInfos.get(i3).Vr;
                }
            } else {
                return null;
            }
        }
    }

    public af.a K(Context context) {
        TextView textView = new TextView(context);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int dip2px = com.baidu.adp.lib.util.l.dip2px(context, 15.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        textView.setHeight(0);
        return new b(textView);
    }

    /* loaded from: classes.dex */
    class b extends af.a {
        public b(View view) {
            super(view);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public af.a Vr;
        public Object data;
        public long id;
        public boolean isSelectable;
        public int type;

        public c() {
        }
    }
}
