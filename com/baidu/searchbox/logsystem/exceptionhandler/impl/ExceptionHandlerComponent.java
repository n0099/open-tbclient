package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.nf1;
import com.baidu.tieba.pf1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public pf1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        nf1 b = nf1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
