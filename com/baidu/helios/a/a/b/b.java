package com.baidu.helios.a.a.b;
/* loaded from: classes8.dex */
class b extends com.baidu.helios.a.a.a.a {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:129:0x019a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.helios.a.a.a.c
    public java.lang.String a(java.lang.String r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, org.json.JSONObject r12) {
        /*
            r8 = this;
            r4 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L10
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "urlStr should not be null"
            r0.<init>(r1)
            throw r0
        L10:
            r5 = 0
            java.lang.String r3 = ""
            java.net.URL r0 = new java.net.URL     // Catch: java.io.UnsupportedEncodingException -> L103 java.net.ProtocolException -> L123 java.io.IOException -> L143 java.lang.Throwable -> L163 java.net.MalformedURLException -> L1b1
            r0.<init>(r9)     // Catch: java.io.UnsupportedEncodingException -> L103 java.net.ProtocolException -> L123 java.io.IOException -> L143 java.lang.Throwable -> L163 java.net.MalformedURLException -> L1b1
            java.net.URLConnection r0 = r0.openConnection()     // Catch: java.io.UnsupportedEncodingException -> L103 java.net.ProtocolException -> L123 java.io.IOException -> L143 java.lang.Throwable -> L163 java.net.MalformedURLException -> L1b1
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.io.UnsupportedEncodingException -> L103 java.net.ProtocolException -> L123 java.io.IOException -> L143 java.lang.Throwable -> L163 java.net.MalformedURLException -> L1b1
            r1 = 15000(0x3a98, float:2.102E-41)
            r0.setConnectTimeout(r1)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            r1 = 15000(0x3a98, float:2.102E-41)
            r0.setReadTimeout(r1)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            r1 = 1
            r0.setDoOutput(r1)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            r0.setRequestMethod(r10)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            if (r11 == 0) goto L74
            int r1 = r11.size()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            if (r1 <= 0) goto L74
            java.util.Set r1 = r11.keySet()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            java.util.Iterator r6 = r1.iterator()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
        L40:
            boolean r1 = r6.hasNext()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            if (r1 == 0) goto L6b
            java.lang.Object r1 = r6.next()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            java.lang.Object r2 = r11.get(r1)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            r0.setRequestProperty(r1, r2)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            goto L40
        L56:
            r1 = move-exception
            r1 = r4
            r2 = r0
            r0 = r4
        L5a:
            if (r2 == 0) goto L5f
            r2.disconnect()
        L5f:
            if (r0 == 0) goto L64
            r0.close()     // Catch: java.io.IOException -> Lf7
        L64:
            if (r1 == 0) goto L69
            r1.close()     // Catch: java.io.IOException -> Lfd
        L69:
            r1 = r4
        L6a:
            return r1
        L6b:
            java.lang.String r1 = "Content-type"
            java.lang.String r2 = "application/json"
            r0.setRequestProperty(r1, r2)     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
        L74:
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch: java.net.MalformedURLException -> L56 java.lang.Throwable -> L180 java.io.IOException -> L193 java.net.ProtocolException -> L19c java.io.UnsupportedEncodingException -> L1a5
            java.lang.String r1 = r12.toString()     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L197 java.net.ProtocolException -> L1a0 java.io.UnsupportedEncodingException -> L1aa java.net.MalformedURLException -> L1b7
            java.lang.String r6 = "utf-8"
            byte[] r1 = r1.getBytes(r6)     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L197 java.net.ProtocolException -> L1a0 java.io.UnsupportedEncodingException -> L1aa java.net.MalformedURLException -> L1b7
            r2.write(r1)     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L197 java.net.ProtocolException -> L1a0 java.io.UnsupportedEncodingException -> L1aa java.net.MalformedURLException -> L1b7
            r2.flush()     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L197 java.net.ProtocolException -> L1a0 java.io.UnsupportedEncodingException -> L1aa java.net.MalformedURLException -> L1b7
            int r1 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L197 java.net.ProtocolException -> L1a0 java.io.UnsupportedEncodingException -> L1aa java.net.MalformedURLException -> L1b7
            r6 = 200(0xc8, float:2.8E-43)
            if (r1 != r6) goto Ldb
            java.io.InputStream r1 = r0.getInputStream()     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L197 java.net.ProtocolException -> L1a0 java.io.UnsupportedEncodingException -> L1aa java.net.MalformedURLException -> L1b7
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L197 java.net.ProtocolException -> L1a0 java.io.UnsupportedEncodingException -> L1aa java.net.MalformedURLException -> L1b7
            java.lang.String r5 = "utf-8"
            r6.<init>(r1, r5)     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L197 java.net.ProtocolException -> L1a0 java.io.UnsupportedEncodingException -> L1aa java.net.MalformedURLException -> L1b7
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L197 java.net.ProtocolException -> L1a0 java.io.UnsupportedEncodingException -> L1aa java.net.MalformedURLException -> L1b7
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L186 java.io.IOException -> L197 java.net.ProtocolException -> L1a0 java.io.UnsupportedEncodingException -> L1aa java.net.MalformedURLException -> L1b7
            java.lang.String r1 = ""
            if (r5 == 0) goto L1c5
            r1 = r3
        La8:
            java.lang.String r3 = r5.readLine()     // Catch: java.io.IOException -> Lc0 java.lang.Throwable -> L18d
            if (r3 == 0) goto Lc1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lc0 java.lang.Throwable -> L18d
            r6.<init>()     // Catch: java.io.IOException -> Lc0 java.lang.Throwable -> L18d
            java.lang.StringBuilder r6 = r6.append(r1)     // Catch: java.io.IOException -> Lc0 java.lang.Throwable -> L18d
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch: java.io.IOException -> Lc0 java.lang.Throwable -> L18d
            java.lang.String r1 = r3.toString()     // Catch: java.io.IOException -> Lc0 java.lang.Throwable -> L18d
            goto La8
        Lc0:
            r3 = move-exception
        Lc1:
            if (r0 == 0) goto Lc6
            r0.disconnect()
        Lc6:
            if (r2 == 0) goto Lcb
            r2.close()     // Catch: java.io.IOException -> Ld6
        Lcb:
            if (r5 == 0) goto L6a
            r5.close()     // Catch: java.io.IOException -> Ld1
            goto L6a
        Ld1:
            r0 = move-exception
            r0.printStackTrace()
            goto L6a
        Ld6:
            r0 = move-exception
            r0.printStackTrace()
            goto Lcb
        Ldb:
            if (r0 == 0) goto Le0
            r0.disconnect()
        Le0:
            if (r2 == 0) goto Le5
            r2.close()     // Catch: java.io.IOException -> Led
        Le5:
            if (r4 == 0) goto Lea
            r5.close()     // Catch: java.io.IOException -> Lf2
        Lea:
            r1 = r4
            goto L6a
        Led:
            r0 = move-exception
            r0.printStackTrace()
            goto Le5
        Lf2:
            r0 = move-exception
            r0.printStackTrace()
            goto Lea
        Lf7:
            r0 = move-exception
            r0.printStackTrace()
            goto L64
        Lfd:
            r0 = move-exception
            r0.printStackTrace()
            goto L69
        L103:
            r0 = move-exception
            r2 = r4
            r5 = r4
            r0 = r4
        L107:
            if (r0 == 0) goto L10c
            r0.disconnect()
        L10c:
            if (r2 == 0) goto L111
            r2.close()     // Catch: java.io.IOException -> L119
        L111:
            if (r5 == 0) goto L116
            r5.close()     // Catch: java.io.IOException -> L11e
        L116:
            r1 = r4
            goto L6a
        L119:
            r0 = move-exception
            r0.printStackTrace()
            goto L111
        L11e:
            r0 = move-exception
            r0.printStackTrace()
            goto L116
        L123:
            r0 = move-exception
            r2 = r4
            r5 = r4
            r0 = r4
        L127:
            if (r0 == 0) goto L12c
            r0.disconnect()
        L12c:
            if (r2 == 0) goto L131
            r2.close()     // Catch: java.io.IOException -> L139
        L131:
            if (r5 == 0) goto L136
            r5.close()     // Catch: java.io.IOException -> L13e
        L136:
            r1 = r4
            goto L6a
        L139:
            r0 = move-exception
            r0.printStackTrace()
            goto L131
        L13e:
            r0 = move-exception
            r0.printStackTrace()
            goto L136
        L143:
            r0 = move-exception
            r2 = r4
            r5 = r4
            r0 = r4
        L147:
            if (r0 == 0) goto L14c
            r0.disconnect()
        L14c:
            if (r2 == 0) goto L151
            r2.close()     // Catch: java.io.IOException -> L159
        L151:
            if (r5 == 0) goto L156
            r5.close()     // Catch: java.io.IOException -> L15e
        L156:
            r1 = r4
            goto L6a
        L159:
            r0 = move-exception
            r0.printStackTrace()
            goto L151
        L15e:
            r0 = move-exception
            r0.printStackTrace()
            goto L156
        L163:
            r0 = move-exception
            r5 = r4
            r1 = r4
        L166:
            if (r1 == 0) goto L16b
            r1.disconnect()
        L16b:
            if (r4 == 0) goto L170
            r4.close()     // Catch: java.io.IOException -> L176
        L170:
            if (r5 == 0) goto L175
            r5.close()     // Catch: java.io.IOException -> L17b
        L175:
            throw r0
        L176:
            r1 = move-exception
            r1.printStackTrace()
            goto L170
        L17b:
            r1 = move-exception
            r1.printStackTrace()
            goto L175
        L180:
            r1 = move-exception
            r5 = r4
            r7 = r1
            r1 = r0
            r0 = r7
            goto L166
        L186:
            r1 = move-exception
            r5 = r4
            r4 = r2
            r7 = r1
            r1 = r0
            r0 = r7
            goto L166
        L18d:
            r1 = move-exception
            r4 = r2
            r7 = r1
            r1 = r0
            r0 = r7
            goto L166
        L193:
            r1 = move-exception
            r2 = r4
            r5 = r4
            goto L147
        L197:
            r1 = move-exception
            r5 = r4
            goto L147
        L19a:
            r1 = move-exception
            goto L147
        L19c:
            r1 = move-exception
            r2 = r4
            r5 = r4
            goto L127
        L1a0:
            r1 = move-exception
            r5 = r4
            goto L127
        L1a3:
            r1 = move-exception
            goto L127
        L1a5:
            r1 = move-exception
            r2 = r4
            r5 = r4
            goto L107
        L1aa:
            r1 = move-exception
            r5 = r4
            goto L107
        L1ae:
            r1 = move-exception
            goto L107
        L1b1:
            r0 = move-exception
            r0 = r4
            r1 = r4
            r2 = r4
            goto L5a
        L1b7:
            r1 = move-exception
            r1 = r4
            r7 = r2
            r2 = r0
            r0 = r7
            goto L5a
        L1be:
            r1 = move-exception
            r1 = r5
            r7 = r2
            r2 = r0
            r0 = r7
            goto L5a
        L1c5:
            r1 = r3
            goto Lc1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.helios.a.a.b.b.a(java.lang.String, java.lang.String, java.util.Map, org.json.JSONObject):java.lang.String");
    }
}
