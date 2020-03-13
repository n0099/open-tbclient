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
    private List<InvoiceInfo> cdL = new ArrayList();
    private b ceK;
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
        int aiQ;
        if (list != null && list.size() > 0) {
            this.cdL.clear();
            this.cdL.addAll(list);
            if (this.cdL.get(0).mIsDefault != 1 && (aiQ = aiQ()) >= 0) {
                a(this.cdL.get(aiQ), false);
            }
            notifyDataSetChanged();
        }
    }

    public void aO(long j) {
        if (this.cdL != null && this.cdL.size() > 0) {
            for (int i = 0; i < this.cdL.size(); i++) {
                InvoiceInfo invoiceInfo = this.cdL.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.cdL.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.cdL.size()) {
                        notifyItemRangeChanged(0, this.cdL.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.cdL != null && invoiceInfo != null) {
            this.cdL.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void aP(long j) {
        int aQ;
        if (this.cdL != null && (aQ = aQ(j)) >= 0) {
            int aiQ = aiQ();
            if (aiQ >= 0) {
                this.cdL.get(aiQ).mIsDefault = 0;
                notifyItemChanged(aiQ);
            }
            this.cdL.get(aQ).mIsDefault = 1;
            notifyItemChanged(aQ);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int aQ;
        if (this.cdL != null && (aQ = aQ(invoiceInfo.mId)) >= 0) {
            this.cdL.set(aQ, invoiceInfo);
            notifyItemChanged(aQ);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.cdL != null && this.cdL.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.cdL.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.cdL.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.cdL.remove(i);
                    this.cdL.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int aiQ() {
        if (this.cdL == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cdL.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cdL.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int aQ(long j) {
        if (this.cdL == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cdL.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cdL.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.ceK = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0322a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0322a c0322a = new C0322a(LayoutInflater.from(this.mContext).inflate(b.f.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0322a.ceM.aiR();
        } else if (i == 1) {
            c0322a.ceM.aiS();
        }
        return c0322a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0322a c0322a, int i) {
        final InvoiceInfo invoiceInfo = this.cdL.get(i);
        if (invoiceInfo != null) {
            if (c0322a.getItemViewType() == 0) {
                c0322a.ceM.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.mTaxNumber);
            } else if (c0322a.getItemViewType() == 1) {
                c0322a.ceM.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0322a.ceM.es(true);
            } else {
                c0322a.ceM.es(false);
            }
            c0322a.ceM.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.ceK != null) {
                        a.this.ceK.b(view, invoiceInfo);
                    }
                }
            });
            c0322a.ceM.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.ceK != null) {
                        a.this.ceK.a(view, invoiceInfo);
                    }
                }
            });
            c0322a.ceM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.ceK != null) {
                        a.this.ceK.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cdL != null) {
            return this.cdL.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.cdL != null) {
            InvoiceInfo invoiceInfo = this.cdL.get(i);
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
        InvoiceListItemView ceM;

        public C0322a(View view) {
            super(view);
            this.ceM = (InvoiceListItemView) view.findViewById(b.e.invoice_list_item);
        }
    }
}
