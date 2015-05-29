package com.baidu.adp.lib.util;
/* loaded from: classes.dex */
class t extends BlockingLinkedDeque<E>.s {
    final /* synthetic */ BlockingLinkedDeque yP;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private t(BlockingLinkedDeque blockingLinkedDeque) {
        super(blockingLinkedDeque);
        this.yP = blockingLinkedDeque;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(BlockingLinkedDeque blockingLinkedDeque, t tVar) {
        this(blockingLinkedDeque);
    }

    v<E> jt() {
        return this.yP.last;
    }

    v<E> c(v<E> vVar) {
        return vVar.yQ;
    }
}
