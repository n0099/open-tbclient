package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.TypeAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    public a WC = null;
    public ArrayList<c> mFooterViewInfos;
    public ArrayList<c> mHeaderViewInfos;

    /* loaded from: classes.dex */
    public interface a {
        void onPreLoad();
    }

    public d() {
        this.mHeaderViewInfos = null;
        this.mFooterViewInfos = null;
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
    }

    public void a(a aVar) {
        this.WC = aVar;
    }

    public int z(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mHeaderViewInfos.size()) {
                c cVar = this.mHeaderViewInfos.get(i2);
                if (cVar == null || cVar.WE == null || cVar.WE.itemView != view) {
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
                if (cVar == null || cVar.WE == null || cVar.WE.itemView != view) {
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

    public void a(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            c cVar = new c();
            cVar.WE = new TypeAdapter.ViewHolder(view);
            cVar.data = obj;
            cVar.isSelectable = z;
            cVar.WF = z2;
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

    public void b(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            c cVar = new c();
            cVar.WE = new TypeAdapter.ViewHolder(view);
            cVar.data = obj;
            cVar.isSelectable = z;
            cVar.WF = z2;
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
            if (cVar != null && cVar.WE != null && cVar.WE.itemView == view) {
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
            if (cVar != null && cVar.WE != null && cVar.WE.itemView == view) {
                this.mFooterViewInfos.remove(i);
                return true;
            }
        }
        return false;
    }

    public c aS(int i) {
        Iterator<c> it = this.mHeaderViewInfos.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i == next.type) {
                return next;
            }
        }
        return null;
    }

    public c aT(int i) {
        Iterator<c> it = this.mFooterViewInfos.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && i == next.type) {
                return next;
            }
        }
        return null;
    }

    public TypeAdapter.ViewHolder M(Context context) {
        TextView textView = new TextView(context);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int dip2px = com.baidu.adp.lib.util.l.dip2px(context, 15.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        textView.setHeight(0);
        return new b(textView);
    }

    /* loaded from: classes.dex */
    class b extends TypeAdapter.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public TypeAdapter.ViewHolder WE;
        public boolean WF;
        public Object data;
        public long id;
        public boolean isSelectable;
        public int type;

        public c() {
        }
    }
}
