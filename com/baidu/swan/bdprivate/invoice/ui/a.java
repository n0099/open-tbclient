package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends RecyclerView.Adapter<C0373a> {
    private b cDZ;
    private List<InvoiceInfo> cDa = new ArrayList();
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface b {
        void a(View view, InvoiceInfo invoiceInfo);

        void b(View view, InvoiceInfo invoiceInfo);

        void c(View view, InvoiceInfo invoiceInfo);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void ak(List<InvoiceInfo> list) {
        int ara;
        if (list != null && list.size() > 0) {
            this.cDa.clear();
            this.cDa.addAll(list);
            if (this.cDa.get(0).mIsDefault != 1 && (ara = ara()) >= 0) {
                a(this.cDa.get(ara), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bt(long j) {
        if (this.cDa != null && this.cDa.size() > 0) {
            for (int i = 0; i < this.cDa.size(); i++) {
                InvoiceInfo invoiceInfo = this.cDa.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.cDa.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.cDa.size()) {
                        notifyItemRangeChanged(0, this.cDa.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.cDa != null && invoiceInfo != null) {
            this.cDa.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bu(long j) {
        int bv;
        if (this.cDa != null && (bv = bv(j)) >= 0) {
            int ara = ara();
            if (ara >= 0) {
                this.cDa.get(ara).mIsDefault = 0;
                notifyItemChanged(ara);
            }
            this.cDa.get(bv).mIsDefault = 1;
            notifyItemChanged(bv);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bv;
        if (this.cDa != null && (bv = bv(invoiceInfo.mId)) >= 0) {
            this.cDa.set(bv, invoiceInfo);
            notifyItemChanged(bv);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.cDa != null && this.cDa.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.cDa.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.cDa.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.cDa.remove(i);
                    this.cDa.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int ara() {
        if (this.cDa == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cDa.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cDa.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bv(long j) {
        if (this.cDa == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cDa.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cDa.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.cDZ = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0373a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0373a c0373a = new C0373a(LayoutInflater.from(this.mContext).inflate(b.f.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0373a.cEb.arb();
        } else if (i == 1) {
            c0373a.cEb.arc();
        }
        return c0373a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0373a c0373a, int i) {
        final InvoiceInfo invoiceInfo = this.cDa.get(i);
        if (invoiceInfo != null) {
            if (c0373a.getItemViewType() == 0) {
                c0373a.cEb.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.mTaxNumber);
            } else if (c0373a.getItemViewType() == 1) {
                c0373a.cEb.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0373a.cEb.fq(true);
            } else {
                c0373a.cEb.fq(false);
            }
            c0373a.cEb.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.cDZ != null) {
                        a.this.cDZ.b(view, invoiceInfo);
                    }
                }
            });
            c0373a.cEb.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.cDZ != null) {
                        a.this.cDZ.a(view, invoiceInfo);
                    }
                }
            });
            c0373a.cEb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.cDZ != null) {
                        a.this.cDZ.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cDa != null) {
            return this.cDa.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.cDa != null) {
            InvoiceInfo invoiceInfo = this.cDa.get(i);
            if (invoiceInfo != null && invoiceInfo.mType == 0) {
                return 0;
            }
            if (invoiceInfo != null && invoiceInfo.mType == 1) {
                return 1;
            }
        }
        return super.getItemViewType(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.bdprivate.invoice.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0373a extends RecyclerView.ViewHolder {
        InvoiceListItemView cEb;

        public C0373a(View view) {
            super(view);
            this.cEb = (InvoiceListItemView) view.findViewById(b.e.invoice_list_item);
        }
    }
}
