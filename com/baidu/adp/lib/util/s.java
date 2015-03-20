package com.baidu.adp.lib.util;
/* loaded from: classes.dex */
class s extends BlockingLinkedDeque<E>.r {
    final /* synthetic */ BlockingLinkedDeque za;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private s(BlockingLinkedDeque blockingLinkedDeque) {
        super(blockingLinkedDeque);
        this.za = blockingLinkedDeque;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(BlockingLinkedDeque blockingLinkedDeque, s sVar) {
        this(blockingLinkedDeque);
    }

    u<E> jc() {
        return this.za.last;
    }

    u<E> c(u<E> uVar) {
        return uVar.zb;
    }
}
