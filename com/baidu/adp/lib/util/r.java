package com.baidu.adp.lib.util;
/* loaded from: classes.dex */
class r extends BlockingLinkedDeque<E>.p {
    final /* synthetic */ BlockingLinkedDeque nD;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private r(BlockingLinkedDeque blockingLinkedDeque) {
        super(blockingLinkedDeque);
        this.nD = blockingLinkedDeque;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(BlockingLinkedDeque blockingLinkedDeque, r rVar) {
        this(blockingLinkedDeque);
    }

    s<E> fz() {
        return this.nD.first;
    }

    s<E> c(s<E> sVar) {
        return sVar.nB;
    }
}
