package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.aj1;
import com.baidu.tieba.cj1;
/* loaded from: classes2.dex */
public class ExceptionHandlerComponent {
    @Inject
    public cj1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        aj1 b = aj1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
