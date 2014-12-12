package com.baidu.adp.lib.util;
/* loaded from: classes.dex */
class r extends BlockingLinkedDeque<E>.p {
    final /* synthetic */ BlockingLinkedDeque nA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private r(BlockingLinkedDeque blockingLinkedDeque) {
        super(blockingLinkedDeque);
        this.nA = blockingLinkedDeque;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(BlockingLinkedDeque blockingLinkedDeque, r rVar) {
        this(blockingLinkedDeque);
    }

    s<E> fA() {
        return this.nA.first;
    }

    s<E> c(s<E> sVar) {
        return sVar.ny;
    }
}
