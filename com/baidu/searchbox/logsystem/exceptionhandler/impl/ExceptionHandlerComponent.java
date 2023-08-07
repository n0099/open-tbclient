package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.dk1;
import com.baidu.tieba.fk1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public fk1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        dk1 b = dk1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
