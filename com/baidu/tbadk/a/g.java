package com.baidu.tbadk.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.b.a<String, com.baidu.adp.widget.a.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.f835a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    /* renamed from: a */
    public int b(String str, com.baidu.adp.widget.a.c cVar) {
        if (cVar != null) {
            return cVar.d();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void a(boolean z, String str, com.baidu.adp.widget.a.c cVar, com.baidu.adp.widget.a.c cVar2) {
        com.baidu.adp.lib.b.a aVar;
        if (cVar != null) {
            if (com.baidu.adp.lib.f.d.a()) {
                StringBuilder append = new StringBuilder("pic removed from cache:").append(cVar.h()).append(", size:").append(cVar.d()).append("/");
                aVar = this.f835a.c;
                com.baidu.adp.lib.f.d.c(append.append(aVar.c()).toString());
            }
            cVar.e();
        }
    }
}
