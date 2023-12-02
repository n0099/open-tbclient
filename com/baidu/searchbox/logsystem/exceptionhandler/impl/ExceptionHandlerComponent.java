package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.qf1;
import com.baidu.tieba.sf1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public sf1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        qf1 b = qf1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
