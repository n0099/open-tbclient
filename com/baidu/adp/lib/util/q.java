package com.baidu.adp.lib.util;
/* loaded from: classes.dex */
class q extends BlockingLinkedDeque<E>.p {
    final /* synthetic */ BlockingLinkedDeque nA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private q(BlockingLinkedDeque blockingLinkedDeque) {
        super(blockingLinkedDeque);
        this.nA = blockingLinkedDeque;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(BlockingLinkedDeque blockingLinkedDeque, q qVar) {
        this(blockingLinkedDeque);
    }

    s<E> fA() {
        return this.nA.last;
    }

    s<E> c(s<E> sVar) {
        return sVar.nB;
    }
}
