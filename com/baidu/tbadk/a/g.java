package com.baidu.tbadk.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.c.a {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    /* renamed from: a */
    public int b(String str, com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            return bVar.d();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    public void a(boolean z, String str, com.baidu.adp.widget.a.b bVar, com.baidu.adp.widget.a.b bVar2) {
        com.baidu.adp.lib.c.a aVar;
        if (bVar != null) {
            if (com.baidu.adp.lib.e.b.a()) {
                StringBuilder append = new StringBuilder("pic removed from cache:").append(bVar.i()).append(", size:").append(bVar.d()).append("/");
                aVar = this.a.c;
                com.baidu.adp.lib.e.b.c(append.append(aVar.c()).toString());
            }
            bVar.e();
        }
    }
}
