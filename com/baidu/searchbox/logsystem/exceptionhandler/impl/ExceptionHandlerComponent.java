package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.lk1;
import com.baidu.tieba.nk1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public nk1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        lk1 b = lk1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
