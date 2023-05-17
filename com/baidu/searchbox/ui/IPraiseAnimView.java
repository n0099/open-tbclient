package com.baidu.searchbox.ui;

import android.view.View;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener;
import com.baidu.searchbox.ui.animview.praise.data.ComboPraiseConfig;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\bH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\bH&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/ui/IPraiseAnimView;", "", "addPraiseAnimListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/searchbox/ui/animview/praise/IPraiseAnimListener;", "click", "vibrateForOnce", "", "enablePopTouchable", "getViewInstance", "Landroid/view/View;", "setAnimInfo", "url", "", "setClickBlock", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "setLongClickStatus", "longClickStatus", "setPraiseConfig", "config", "Lcom/baidu/searchbox/ui/animview/praise/data/ComboPraiseConfig;", "setProvider", "provider", "Lcom/baidu/searchbox/ui/animview/base/IResourceProvider;", "lib-praise_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IPraiseAnimView {
    void addPraiseAnimListener(IPraiseAnimListener iPraiseAnimListener);

    void click(boolean z);

    boolean enablePopTouchable();

    View getViewInstance();

    void setAnimInfo(String str);

    void setClickBlock(boolean z);

    void setLongClickStatus(boolean z);

    void setPraiseConfig(ComboPraiseConfig comboPraiseConfig);

    boolean setProvider(IResourceProvider iResourceProvider);
}
