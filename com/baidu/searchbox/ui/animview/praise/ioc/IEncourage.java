package com.baidu.searchbox.ui.animview.praise.ioc;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J(\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/ui/animview/praise/ioc/IEncourage;", "", "needShowEasterEgg", "", "params", "", "", "showEasterEgg", "context", "Landroid/content/Context;", "updatePraiseClickNum", "", "updatePraiseTime", "Companion", "lib-praise_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IEncourage {
    public static final Companion Companion = Companion.$$INSTANCE;
    @JvmField
    public static final IEncourage empty = new IEncourage() { // from class: com.baidu.searchbox.ui.animview.praise.ioc.IEncourage$Companion$empty$1
        @Override // com.baidu.searchbox.ui.animview.praise.ioc.IEncourage
        public boolean needShowEasterEgg(Map<String, String> map) {
            return false;
        }

        @Override // com.baidu.searchbox.ui.animview.praise.ioc.IEncourage
        public boolean showEasterEgg(Context context, Map<String, String> map) {
            return false;
        }

        @Override // com.baidu.searchbox.ui.animview.praise.ioc.IEncourage
        public void updatePraiseClickNum() {
        }

        @Override // com.baidu.searchbox.ui.animview.praise.ioc.IEncourage
        public void updatePraiseTime() {
        }
    };

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/ui/animview/praise/ioc/IEncourage$Companion;", "", "()V", SchemeCollecter.CLASSIFY_EMPTY, "Lcom/baidu/searchbox/ui/animview/praise/ioc/IEncourage;", "lib-praise_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
    }

    boolean needShowEasterEgg(Map<String, String> map);

    boolean showEasterEgg(Context context, Map<String, String> map);

    void updatePraiseClickNum();

    void updatePraiseTime();
}
