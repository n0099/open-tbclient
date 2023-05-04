package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ej1;
import com.baidu.tieba.gj1;
/* loaded from: classes2.dex */
public class ExceptionHandlerComponent {
    @Inject
    public gj1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        ej1 b = ej1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
