package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.el1;
import com.baidu.tieba.gl1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public gl1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        el1 b = el1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
