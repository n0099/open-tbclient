package com.baidu.adp.lib.util;
/* loaded from: classes.dex */
class t extends BlockingLinkedDeque<E>.r {
    final /* synthetic */ BlockingLinkedDeque za;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private t(BlockingLinkedDeque blockingLinkedDeque) {
        super(blockingLinkedDeque);
        this.za = blockingLinkedDeque;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(BlockingLinkedDeque blockingLinkedDeque, t tVar) {
        this(blockingLinkedDeque);
    }

    u<E> jc() {
        return this.za.first;
    }

    u<E> c(u<E> uVar) {
        return uVar.yY;
    }
}
