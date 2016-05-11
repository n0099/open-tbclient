package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ UserLikeButton adX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(UserLikeButton userLikeButton) {
        this.adX = userLikeButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Context context;
        ax axVar;
        ax axVar2;
        com.baidu.tbadk.coreExtra.d.a aVar;
        String str;
        View.OnClickListener onClickListener2;
        Context context2;
        Context context3;
        if (!com.baidu.adp.lib.util.i.fe()) {
            context2 = this.adX.mContext;
            if (context2 != null) {
                context3 = this.adX.mContext;
                com.baidu.adp.lib.util.k.showToast(context3, t.j.network_ungeilivable);
            }
        }
        onClickListener = this.adX.aac;
        if (onClickListener != null) {
            onClickListener2 = this.adX.aac;
            onClickListener2.onClick(this.adX);
        }
        context = this.adX.mContext;
        if (bl.ac(context)) {
            axVar = this.adX.aab;
            if (axVar != null) {
                axVar2 = this.adX.aab;
                MetaData author = axVar2.getAuthor();
                if (author != null && author.getGodUserData() != null) {
                    boolean z = author.getGodUserData().getFollowed() == 1;
                    aVar = this.adX.adU;
                    boolean z2 = !z;
                    String portrait = author.getPortrait();
                    String userId = author.getUserId();
                    str = this.adX.adV;
                    aVar.a(z2, portrait, userId, false, str);
                }
            }
        }
    }
}
