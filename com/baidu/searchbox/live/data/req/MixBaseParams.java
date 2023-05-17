package com.baidu.searchbox.live.data.req;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0007\b&\u0018\u0000B\u001b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\tJ!\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/live/data/req/MixBaseParams;", "Lkotlin/Pair;", "", "extParams", "", "addExtParams", "(Lkotlin/Pair;)V", "key", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "", "toMap", "()Ljava/util/Map;", "extReq", "Ljava/lang/String;", "getExtReq", "()Ljava/lang/String;", "setExtReq", "(Ljava/lang/String;)V", "", "store", "Ljava/util/Map;", "tpl", "getTpl", "setTpl", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class MixBaseParams {
    public String extReq;
    public final Map<String, String> store;
    public String tpl;

    public MixBaseParams() {
        this(null, null, 3, null);
    }

    public MixBaseParams(String str, String str2) {
        this.tpl = str;
        this.extReq = str2;
        this.store = new LinkedHashMap();
    }

    public final void addExtParams(String str, String str2) {
        this.store.put(str, str2);
    }

    public /* synthetic */ MixBaseParams(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final void addExtParams(Pair<String, String> pair) {
        this.store.put(pair.getFirst(), pair.getSecond());
    }

    public void setExtReq(String str) {
        this.extReq = str;
    }

    public void setTpl(String str) {
        this.tpl = str;
    }

    public String getExtReq() {
        return this.extReq;
    }

    public String getTpl() {
        return this.tpl;
    }

    public Map<String, String> toMap() {
        this.store.put("tpl", getTpl());
        this.store.put("extRequest", getExtReq());
        return this.store;
    }
}
