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
public class a extends RecyclerView.Adapter<C0322a> {
    private List<InvoiceInfo> cdW = new ArrayList();
    private b ceV;
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

    public void ac(List<InvoiceInfo> list) {
        int aiT;
        if (list != null && list.size() > 0) {
            this.cdW.clear();
            this.cdW.addAll(list);
            if (this.cdW.get(0).mIsDefault != 1 && (aiT = aiT()) >= 0) {
                a(this.cdW.get(aiT), false);
            }
            notifyDataSetChanged();
        }
    }

    public void aO(long j) {
        if (this.cdW != null && this.cdW.size() > 0) {
            for (int i = 0; i < this.cdW.size(); i++) {
                InvoiceInfo invoiceInfo = this.cdW.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.cdW.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.cdW.size()) {
                        notifyItemRangeChanged(0, this.cdW.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.cdW != null && invoiceInfo != null) {
            this.cdW.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void aP(long j) {
        int aQ;
        if (this.cdW != null && (aQ = aQ(j)) >= 0) {
            int aiT = aiT();
            if (aiT >= 0) {
                this.cdW.get(aiT).mIsDefault = 0;
                notifyItemChanged(aiT);
            }
            this.cdW.get(aQ).mIsDefault = 1;
            notifyItemChanged(aQ);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int aQ;
        if (this.cdW != null && (aQ = aQ(invoiceInfo.mId)) >= 0) {
            this.cdW.set(aQ, invoiceInfo);
            notifyItemChanged(aQ);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.cdW != null && this.cdW.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.cdW.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.cdW.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.cdW.remove(i);
                    this.cdW.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int aiT() {
        if (this.cdW == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cdW.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cdW.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int aQ(long j) {
        if (this.cdW == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cdW.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cdW.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.ceV = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0322a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0322a c0322a = new C0322a(LayoutInflater.from(this.mContext).inflate(b.f.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0322a.ceX.aiU();
        } else if (i == 1) {
            c0322a.ceX.aiV();
        }
        return c0322a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0322a c0322a, int i) {
        final InvoiceInfo invoiceInfo = this.cdW.get(i);
        if (invoiceInfo != null) {
            if (c0322a.getItemViewType() == 0) {
                c0322a.ceX.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.mTaxNumber);
            } else if (c0322a.getItemViewType() == 1) {
                c0322a.ceX.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0322a.ceX.et(true);
            } else {
                c0322a.ceX.et(false);
            }
            c0322a.ceX.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.ceV != null) {
                        a.this.ceV.b(view, invoiceInfo);
                    }
                }
            });
            c0322a.ceX.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.ceV != null) {
                        a.this.ceV.a(view, invoiceInfo);
                    }
                }
            });
            c0322a.ceX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.ceV != null) {
                        a.this.ceV.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cdW != null) {
            return this.cdW.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.cdW != null) {
            InvoiceInfo invoiceInfo = this.cdW.get(i);
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
    public class C0322a extends RecyclerView.ViewHolder {
        InvoiceListItemView ceX;

        public C0322a(View view) {
            super(view);
            this.ceX = (InvoiceListItemView) view.findViewById(b.e.invoice_list_item);
        }
    }
}
