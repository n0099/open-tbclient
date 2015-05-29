package com.baidu.adp.lib.util;
/* loaded from: classes.dex */
class u extends BlockingLinkedDeque<E>.s {
    final /* synthetic */ BlockingLinkedDeque yP;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private u(BlockingLinkedDeque blockingLinkedDeque) {
        super(blockingLinkedDeque);
        this.yP = blockingLinkedDeque;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(BlockingLinkedDeque blockingLinkedDeque, u uVar) {
        this(blockingLinkedDeque);
    }

    v<E> jt() {
        return this.yP.first;
    }

    v<E> c(v<E> vVar) {
        return vVar.yN;
    }
}
