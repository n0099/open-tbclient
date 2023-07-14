package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.al1;
import com.baidu.tieba.cl1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public cl1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        al1 b = al1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
